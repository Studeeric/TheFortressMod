package thefortress.cards.skills;

import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thefortress.cards.BaseCard;
import thefortress.character.TheFortress;
import thefortress.util.CardInfo;

import static thefortress.TheFortressMod.makeID;

public class DrawYourShield extends BaseCard {
    public static final CardInfo cardInfo = new CardInfo(
            "DrawYourShield",
            2,
            CardType.SKILL,
            CardTarget.NONE,
            CardRarity.UNCOMMON,
            TheFortress.Enums.CARD_COLOR
    );

    public static final String ID = makeID(cardInfo.baseId);

    public static int AMOUNT = 10;

    public DrawYourShield(){
        super(cardInfo);

        setMagic(AMOUNT);
        setCostUpgrade(1);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        addToBot(new DrawCardAction(abstractPlayer, calcBlockByAmount(abstractPlayer.currentBlock), false));
    }

    @Override
    public AbstractCard makeCopy() {
        return new DrawYourShield();
    }

    public int calcBlockByAmount(int currentBlock){
        return currentBlock / magicNumber;
    }
}
