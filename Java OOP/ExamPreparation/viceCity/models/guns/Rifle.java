package viceCity.models.guns;

public class Rifle extends BaseGun{
    private static final int BULLETS_PER_BARREL = 50;
    private static final int TOTAL_BULLETS = 500;
    private static final int BULLETS_PER_SHOT = 5;

    public Rifle(String name) {
        super(name, BULLETS_PER_BARREL, TOTAL_BULLETS);
    }

    @Override
    public int getBulletsPerBarrel() {
        return BULLETS_PER_BARREL;
    }

    @Override
    public int getTotalBullets() {
        return TOTAL_BULLETS;
    }

    @Override
    public int fire() {
        if (getBulletsPerBarrel() < 5 && getTotalBullets() >= 5) {
            reload();
        }

        if (getBulletsPerBarrel() >= 5) {
            this.setBulletsPerBarrel(getBulletsPerBarrel() - BULLETS_PER_SHOT);
        }
        return BULLETS_PER_SHOT;
    }

    private void reload() {
        this.setTotalBullets(getTotalBullets() - BULLETS_PER_BARREL);
        this.setBulletsPerBarrel(BULLETS_PER_BARREL);
    }
}
