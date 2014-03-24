
public abstract class Enemy {
	
	Source source;
	Road road;
	Obstacle obstacle;
	
	public Enemy() {
		source = null;
		road = null;
		obstacle = null;
	}
	
	public void createObject() {
		source = new Source();
		road = new Road();
		obstacle = new Obstacle();
	}
	
	/**
	 * A parameterkent kapott poziciora lepteti az ellenseget.
	 * 
	 * @param p A leptetes celpozicioja
	 */
	public void move() {
		Writer.entry();
		road.requestDestination(this);
		Writer.asynchronexit();
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
		Writer.entry();
		Writer.synchronexit();
		return 0;
	}
	
	/**
	 * Az ellenseg aktivitasat allitja (~kirajzolas)
	 * @param a Ha true akkor aktiv lesz, ha false akkor passziv
	 */
	public void setActivity(boolean a) {
		Writer.entry();
		Writer.asynchronexit();
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
