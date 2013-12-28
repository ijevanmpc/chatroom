package com.mpci.catalogsample;
/**
 * This class is used for save information about users
 * @author Lilit & Serine
 *
 */
public class ListData {
	/**
	 * User name
	 */
	String name;
	/**
	 *  User age
	 */
	int age;
	/**
	 * Link to image
	 */
	int image;

	ListData(String _name, int _age, int _image) {
		name = _name;
		age = _age;
		image = _image;
	}
}