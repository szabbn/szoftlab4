
public abstract class Enemy {
	
	protected int lifePower;
	protected int stepTime;
	protected int pause;
	protected Road road;
	protected boolean isActive;
	protected boolean isDuplicated;
	
	public Enemy() {
		lifePower = 100;
		stepTime = 10;
		pause = 0;
		road = null;
		isActive = false;
		isDuplicated = false;
	}
	
	public Enemy(Position pos) {
		lifePower = 100;
		stepTime = 10;
		pause = 0;
		road = new Road(pos);
		isActive = false;
		isDuplicated = false;
	}

	
	
	public int getLifePower() {
		return lifePower;
	}



	public void setLifePower(int lifePower) {
		this.lifePower = lifePower;
	}



	public int getStepTime() {
		return stepTime;
	}



	public void setStepTime(int stepTime) {
		this.stepTime = stepTime;
	}



	public int getPause() {
		return pause;
	}



	public void setPause(int pause) {
		this.pause = pause;
	}



	public boolean isActive() {
		return isActive;
	}


	public boolean isDuplicated() {
		return isDuplicated;
	}



	public void setDuplicated(boolean isDuplicated) {
		this.isDuplicated = isDuplicated;
	}



	public Road getRoad() {
		return road;
	}



	/**
	 * A parameterkent kapott poziciora lepteti az ellenseget.
	 * 
	 * @param p A leptetes celpozicioja
	 */
	public void move() {
		road.requestDestination(this);
	}

	/**
	 * A parameterlistan kapott toronytol leolvasott,
	 * erre az ellenseg tipusra vonatkozo sebzes erteket
	 * levonja az aktualis eleterobol.
	 * 
	 * @param t A torony amelyik eppen lo erre az ellensegre
	 */
	public abstract void lifePowerReduce(Tower t);

	/**
	 * Ellenseg forras poticiora helyezese
	 * @param pause A kesleltetes erteke, ami megadja a palyara lepes sorrendjet
	 */
	public void goToSource(int pause){
		Writer.entry();
		source.requestDestination(this);
		Writer.asynchronexit();
	}

	/**
	 * A varakozas ertekenek novelese (palyara helyezeskor vagy lassitaskor fordul elo)
	 * @param slowingFactor Az akadaly lassito tenyezoje
	 */
	public void increasePause(int slowingFactor){
		Writer.entry();
		Writer.asynchronexit();
	}		

	/**
	 * Az ellenseget sebzi
	 * @param t
	 * @return
	 */
	public int hit(Tower t){
		this.lifePowerReduce(t);
		return this.lifePower;
	}
	
	/**
	 * Az ellenseg aktivitasat allitja (~kirajzolas)
	 * @param a Ha true akkor aktiv lesz, ha false akkor passziv
	 */
	public void setActivity(boolean a) {
		this.isActive = a;
	}
	
	/**
	 * Beallitja az ellenseg poziciojat, amin allnia kell
	 * @param nextroad A kovetkezo ut, ahova lepnie kell 
	 */
	public void setRoad(Road r) {
		Writer.entry();
		if(Writer.question("Kovetkezo ut-csempe akadaly-e?")) {
			obstacle.slowMe(this);
		}
		Writer.asynchronexit();
	}
}
