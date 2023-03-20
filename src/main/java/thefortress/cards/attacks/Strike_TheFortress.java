package thefortress.cards.attacks;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thefortress.cards.BaseCard;
import thefortress.character.TheFortress;
import thefortress.util.CardInfo;

import static thefortress.TheFortressMod.makeID;

public class Strike_TheFortress extends BaseCard {

    public static final CardInfo cardInfo = new CardInfo(
            "Strike_TheFortress",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.BASIC,
            TheFortress.Enums.CARD_COLOR
    );

    public static final String ID = makeID(cardInfo.baseId);
    private static final int DAMAGE = 5;
    private static final int UPG_DAMAGE = 3;

    public Strike_TheFortress(){
        super(cardInfo);

        setDamage(DAMAGE, UPG_DAMAGE);

        tags.add(CardTags.STRIKE);
        tags.add(CardTags.STARTER_STRIKE);
    }


    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        addToBot(new DamageAction(abstractMonster, new DamageInfo(abstractPlayer, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
    }

    @Override
    public AbstractCard makeCopy() {
        return new Strike_TheFortress();
    }
}
