package role;

import mvc.*;
import role.abstractFactory.RoleFactory;

public class AI_Ball extends AI {
	//���|�ܪ��ƭ�
	public static int df;  //���m�O
	public static int atk;  //�Ǫ���Ĳ�I���� �Y���a�h��0

	public AI_Ball(RoleFactory factory) {
		super(factory);
	}
	
	public AI_Ball(RoleFactory factory ,int x , int y , ActionType act , Dir dir) {
		super(factory,x,y,act,dir);
	}

	@Override
	protected void die() {
		
		
	}

	@Override
	int getMovingDistance(ActionType act , Dir dir) {
		//�C�����ʶZ��
		return 5;
	}

}