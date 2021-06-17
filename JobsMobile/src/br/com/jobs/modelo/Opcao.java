package br.com.jobs.modelo;

import java.io.Serializable;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;

@SuppressLint("DefaultLocale")
public class Opcao implements Comparable<Opcao>,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8925039546002885572L;
	private String name;
	private String data;
	private String path;
	private Drawable image;
	
	public Opcao(String n,String d,String p, Drawable i )
	{
		this.name = n;
		this.data = d;
		this.path = p;
		this.image = i;
	}
	public String getName()
	{
		return name;
	}
	public String getData()
	{
		return data;
	}
	public String getPath()
	{
		return path;
	}
	public Drawable getImage() {
		return image;
	}
	public void setImage(Drawable image) {
		this.image = image;
	}
	@Override
	public int compareTo(Opcao o) {
		if(this.name != null)
			return this.name.toLowerCase().compareTo(o.getName().toLowerCase()); 
		else 
			throw new IllegalArgumentException();
	}
	
}
