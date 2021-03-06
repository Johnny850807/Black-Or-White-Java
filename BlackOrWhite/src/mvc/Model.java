package mvc;

import role.Player;
import role.Role;
import weapon.bullets.Bullet;
import weapon.gameEffects.GameEffect;
import weapon.guns.fallenWeapon.FallenItem;

public class Model {
	private Controller controller = Controller.getController(); //更新之後要通知controller
	private Item type;  //是子彈還是角色
	private int cX;
	private int cY;
	private int hp;
	private ActionType act;
	private Dir dir;
	private ImageSequence iS;  //目前的分鏡動作
	private Object parent;  //記錄誰擁有這個model
	
	public Model(Object parent,Item type,int cX,int cY, ActionType act,Dir dir ,ImageSequence iS){
		this.parent = parent;
		this.type = type;
		this.cX = cX;
		this.cY = cY;
		this.act = act;
		this.dir = dir;
		this.iS = iS;
		if (type == Item.BULLET)
			controller.addBullet((Bullet)parent);
		else if ( type == Item.EFFECT )
			controller.addEffect((GameEffect)parent);
	}

	public void setState(int deltaX,int deltaY, ActionType act,Dir dir ,ImageSequence iS){
		this.cX += deltaX;
		this.cY += deltaY;
		this.act = act;
		this.dir = dir;
		this.iS = iS;
	}
	
	//讓這個model在controller中結束生命周期
	public void delete(){
		if ( parent instanceof Role )
			controller.deleteModel((Role)parent);
		else if ( parent instanceof Bullet )
			controller.deleteModel((Bullet)parent);
		else if (parent instanceof FallenItem )
			controller.deleteModel((FallenItem)parent);
		else if (parent instanceof GameEffect)
			controller.deleteModel((GameEffect)parent);
	} 
	
	public Controller getController() {
		return controller;
	}
	public void setController(Controller controller) {
		this.controller = controller;
	}
	public ActionType getAct() {
		return act;
	}
	
	public Dir getDir() {
		return dir;
	}

	public ImageSequence getiS() {
		return iS;
	}

	public Object getParent() {
		if (type == Item.ROLE)
			return (Role)parent;
		if (type == Item.EFFECT )
			return (GameEffect)parent;
		if (type == Item.GUN )
			return (FallenItem)parent;
		return (Bullet)parent;
	}

	public int getcX() {
		return cX;
	}

	public int getcY() {
		return cY;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
		if ( parent instanceof Player)
			controller.updatePlayerHp();
	}

	
	
}
