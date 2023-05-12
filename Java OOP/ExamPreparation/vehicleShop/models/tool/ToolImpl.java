package vehicleShop.models.tool;

import vehicleShop.common.ExceptionMessages;

public class ToolImpl implements Tool{
    private int power;

    public ToolImpl(int power) {
        this.setPower(power);
    }

    public void setPower(int power) {
        if (power < 0) {
            throw new IllegalArgumentException(ExceptionMessages.TOOL_POWER_LESS_THAN_ZERO);
        }
        this.power = power;
    }

    @Override
    public int getPower() {
        return power;
    }

    @Override
    public void decreasesPower() {
        if ((power - 5) < 0) {
            power = 0;
        } else {
            power = power - 5;
        }
    }

    @Override
    public boolean isUnfit() {
        return getPower() == 0;
    }
}
