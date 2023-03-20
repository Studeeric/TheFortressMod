package thefortress.relics;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.BarricadePower;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import thefortress.character.TheFortress;

import static thefortress.TheFortressMod.makeID;

public class TheShield extends BaseRelic{
    private static final String NAME = "TheShield"; //The name will be used for determining the image file as well as the ID.
    public static final String ID = makeID(NAME); //This adds the mod's prefix to the relic ID, resulting in modID:MyRelic
    private static final RelicTier RARITY = RelicTier.STARTER; //The relic's rarity.
    private static final LandingSound SOUND = LandingSound.HEAVY; //The sound played when the relic is clicked.

    public TheShield() {
        super(ID, NAME, TheFortress.Enums.CARD_COLOR, RARITY, SOUND);
    }

    @Override
    public void atBattleStart() {
        addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new BarricadePower(AbstractDungeon.player)));
    }

    @Override
    public String getUpdatedDescription() {
        return String.format(DESCRIPTIONS[0]);
    }

    public AbstractRelic makeCopy() {
        return new TheShield();
    }

}
