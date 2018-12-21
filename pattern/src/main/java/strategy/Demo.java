package strategy;

import strategy.skill.FireBall;
import strategy.skill.IceRain;
import strategy.weapon.Sword;
import strategy.weapon.Woods;

public class Demo {
    public static void main(String[] args) {
        Character gameboy = new Character();

        gameboy.setWeapon(new Sword());
        gameboy.setSkill(new IceRain());
        gameboy.attack();
        gameboy.useMagic();

        System.out.println("\n我要换装备了，各单位注意\n");
        // 这里我要换另一身装备了
        gameboy.setWeapon(new Woods());
        gameboy.setSkill(new FireBall());
        gameboy.attack();
        gameboy.useMagic();
    }
}
