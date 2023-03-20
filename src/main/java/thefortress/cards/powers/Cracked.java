package thefortress.cards.powers;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thefortress.cards.BaseCard;
import thefortress.character.TheFortress;
import thefortress.powers.CrackedPower;
import thefortress.util.CardInfo;

import static thefortress.TheFortressMod.makeID;

public class Cracked extends BaseCard {

    private final static CardInfo cardInfo = new CardInfo(
            "Cracked",
            1,
            CardType.POWER,
            CardTarget.NONE,
            CardRarity.UNCOMMON,
            TheFortress.Enums.CARD_COLOR
    );

    public static final String ID = makeID(cardInfo.baseId);

    public static final int MAGIC_NUMBER = 2;

    public Cracked(){
        super(cardInfo);

        setMagic(MAGIC_NUMBER);
    }


    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new CrackedPower(p, magicNumber)));
    }

    @Override
    public AbstractCard makeCopy() {
        return new Cracked();
    }
}
