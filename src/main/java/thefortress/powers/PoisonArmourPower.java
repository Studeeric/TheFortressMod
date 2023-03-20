package thefortress.powers;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.PoisonPower;

import static thefortress.TheFortressMod.makeID;

public class PoisonArmourPower extends BasePower{

    public static final String POWER_ID = makeID("PoisonArmour");
    private static final AbstractPower.PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = false;

    public PoisonArmourPower(AbstractCreature owner, int amount){
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }

    public int onAttacked(DamageInfo info, int damageAmount) {
        if (info.type != DamageInfo.DamageType.THORNS && info.type != DamageInfo.DamageType.HP_LOSS && info.owner != null && info.owner != this.owner) {
            this.flash();
            this.addToBot(new ApplyPowerAction(info.owner, this.owner, new PoisonPower(info.owner, this.owner, this.amount), this.amount));
        }

        return damageAmount;
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
    }

    @Override
    public AbstractPower makeCopy() {
        return null;
    }
}
