package thefortress.cards.skills;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thefortress.cards.BaseCard;
import thefortress.character.TheFortress;
import thefortress.util.CardInfo;
import thefortress.util.CustomTags;

import static thefortress.TheFortressMod.makeID;

public class Defend_TheFortress extends BaseCard {
    public static final CardInfo cardInfo = new CardInfo(
            "Defend_TheFortress",
            1,
            CardType.SKILL,
            CardTarget.NONE,
            CardRarity.BASIC,
            TheFortress.Enums.CARD_COLOR
    );

    public static final String ID = makeID(cardInfo.baseId);

    public static final int BLOCK = 6;
    public static final int BLOCK_UPG = 3;

    public Defend_TheFortress(){
        super(cardInfo);

        setBlock(BLOCK, BLOCK_UPG);

        tags.add(CardTags.STARTER_DEFEND);
        tags.add(CustomTags.DEFEND);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        addToBot(new GainBlockAction(abstractPlayer, abstractPlayer, block));
    }

    @Override
    public AbstractCard makeCopy() {
        return new Defend_TheFortress();
    }
}
