/**
 * University of Campinas - Brazil
 * Institute of Computing
 * SED group
 *
 * date: February 2009
 * 
 */
//#ifdef Album
package br.unicamp.ic.sed.mobilemedia.photo.impl;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

import br.unicamp.ic.sed.mobilemedia.photo.spec.prov.IManager;

class Manager implements IManager{
	
	Hashtable requiredInterfaces = new Hashtable();
	Hashtable providedInterfaces = new Hashtable();
	
	private IPhotoFacade facade = null;
	
	Manager(){}
	
	
	private String[] convertEnumerationToArray(Enumeration stringEnum){
		Vector stringVector = new Vector();
		for (Enumeration iter = stringEnum; iter.hasMoreElements();) {
			String element = (String) iter.nextElement();
			stringVector.addElement(element);
		}
		
		String[] stringArray = new String[stringVector.size()];
		for (int i=0; i < stringVector.size(); i++){
			stringArray[i] = (String) stringVector.elementAt(i);
		}
		return stringArray;
	}


	
	public String[] getProvidedInterfaces() {
		Enumeration keys = this.providedInterfaces.keys();
		return this.convertEnumerationToArray(keys); 
	}


	public String[] getRequiredInterfaces() {
		Enumeration keys = this.requiredInterfaces.keys();
		return this.convertEnumerationToArray(keys);
	}
	
	public Object getProvidedInterface(String name){
		if( name.equals("IPhoto")){
			if( facade == null )
				this.facade = new IPhotoFacade();
			return facade;
		}
		return null;
	}
	
	public void setRequiredInterface(String name, Object facade){
		this.requiredInterfaces.put(name,facade);
	}
	
	public Object getRequiredInterface(String name){
	   return this.requiredInterfaces.get(name);
	}
	
	
}
//#endif