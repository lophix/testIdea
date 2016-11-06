package pattern.template.method;

/**
 * Created by Administrator on 2016/11/6.
 */
public class TemplateMethodMain {
    public static void main(String[] args) {
        Monster monster = new DragonMonster();
        monster.acttack();
        monster.defense();
        monster.special();
        monster = new WolfMonster();
        monster.acttack();
        monster.defense();
        monster.special();
    }
}
