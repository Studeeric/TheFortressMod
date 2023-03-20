package thefortress.powers;

import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import thefortress.util.CustomTags;

import static thefortress.TheFortressMod.makeID;

public class CrackedPower extends BasePower{
    public static final String POWER_ID = makeID("Cracked");
    private static final AbstractPower.PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = true;

    public CrackedPower(AbstractCreature owner, int amount){
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }

    public float atDamageGive(float damage, DamageInfo.DamageType type, AbstractCard card) {
        if (card.hasTag(CustomTags.SKILLED)){
            return damage * 2;
        }
        return damage;
    }

    public void atEndOfRound() {
        if (this.amount == 0) {
            addToBot(new RemoveSpecificPowerAction(owner, owner, CrackedPower.POWER_ID));
        } else {
            addToBot(new ReducePowerAction(owner, owner, CrackedPower.POWER_ID, 1));
        }
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + amount + DESCRIPTIONS[1];
    }

    //Optional, for CloneablePowerInterface.
    @Override
    public AbstractPower makeCopy() {
        return new CrackedPower(owner, amount);
    }
}
