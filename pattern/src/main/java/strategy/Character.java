package strategy;


import strategy.skill.Skill;
import strategy.weapon.Weapon;

public class Character {

    private Weapon weapon;
    private Skill skill;

    public void attack() {
        System.out.print("武器攻击： ");
        weapon.use();
    }

    public void useMagic() {
        System.out.print("法术攻击： ");
        skill.use();
    }
    /** 两个Setter，用来设置 **/
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

}
