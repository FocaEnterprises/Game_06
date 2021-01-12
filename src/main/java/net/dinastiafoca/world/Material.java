package net.dinastiafoca.world;

public enum Material {
    AIR(0, "Air", false)
    ;
    private final String displayName;
    private final boolean isRigid;
    private final int id;

    Material(int id, String displayName, boolean isRigid) {
       this.id = id;
       this.displayName = displayName;
       this.isRigid = isRigid;
    }

    public int getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public boolean isRigid() {
        return isRigid;
    }
}
