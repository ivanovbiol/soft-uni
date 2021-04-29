
public class Engine {

    public Engine() {
    }

    public void run() {
        MuseElf museElf = new MuseElf("museElf", 1);
        System.out.println(museElf.getUserName());
        System.out.println(museElf.getLevel());
        System.out.println(museElf.toString());

        System.out.println();

        DarkWizard darkWizard = new DarkWizard("darkWizard", 1);
        System.out.println(darkWizard.getUserName());
        System.out.println(darkWizard.getLevel());
        System.out.println(darkWizard.toString());

        System.out.println();

        SoulMaster soulMaster = new SoulMaster("soulMaster", 1);
        System.out.println(soulMaster.getUserName());
        System.out.println(soulMaster.getLevel());
        System.out.println(soulMaster.toString());

        System.out.println();

        DarkKnight darkKnight = new DarkKnight("darkKnight", 1);
        System.out.println(darkKnight.getUserName());
        System.out.println(darkKnight.getLevel());
        System.out.println(darkKnight.toString());

        System.out.println();

        BladeKnight bladeKnight = new BladeKnight("bladeKnight", 1);
        System.out.println(bladeKnight.getUserName());
        System.out.println(bladeKnight.getLevel());
        System.out.println(bladeKnight.toString());
    }
}
