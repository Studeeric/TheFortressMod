package thefortress.cards.powers;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thefortress.cards.BaseCard;
import thefortress.character.TheFortress;
import thefortress.powers.PoisonArmourPower;
import thefortress.util.CardInfo;

import static thefortress.TheFortressMod.makeID;

public class PoisonousLayer extends BaseCard {

    private final static CardInfo cardInfo = new CardInfo(
            "PoisonousLayer",
            1,
            CardType.POWER,
            CardTarget.NONE,
            CardRarity.UNCOMMON,
            TheFortress.Enums.CARD_COLOR
    );

    public static final String ID = makeID(cardInfo.baseId);

    public static final int MAGIC_NUMBER = 2;
    public static final int MAGIC_NUMBER_UPG = 1;

    public PoisonousLayer(){
        super(cardInfo);

        setMagic(MAGIC_NUMBER, MAGIC_NUMBER_UPG);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        addToBot(new ApplyPowerAction(abstractPlayer, abstractPlayer, new PoisonArmourPower(abstractPlayer, magicNumber)));
    }

    @Override
    public AbstractCard makeCopy() {
        return new PoisonousLayer();
    }
}
