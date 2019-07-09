package edu.mum.cs544;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMF{
    private static EntityManagerFactory EMFInstance;

    private EMF(){}

    public static EntityManagerFactory get(){
        if(EMFInstance==null)
            EMFInstance = Persistence.createEntityManagerFactory("cs544");

        return EMFInstance;
    }
}