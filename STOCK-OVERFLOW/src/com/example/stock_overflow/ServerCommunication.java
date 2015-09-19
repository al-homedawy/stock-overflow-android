package com.example.stock_overflow;

import java.util.ArrayList;
import java.util.List;

import com.firebase.client.*;

public class ServerCommunication 
{
	// Variables
	private Firebase m_Server = null;
	private List<String> m_ValueListeners = null;
	private List<String> m_ChildListeners = null;
	
	public ServerCommunication ( String Url )
	{
		// Initialize variables
		m_Server = new Firebase ( Url );
		m_ValueListeners = new ArrayList <String> ();
		m_ChildListeners = new ArrayList <String> ();
		
		if ( m_Server != null )
		{
			// Setup the value listener
			m_Server.addValueEventListener( new ValueEventListener () {

				public void onCancelled(FirebaseError arg0) {
					// An error occured.					
				}

				public void onDataChange(DataSnapshot arg0) {
					// Add the value into our values list
					m_ValueListeners.add( arg0.getValue ().toString () );
				}								
			});
			
			// Setup the class listener
			m_Server.addChildEventListener( new ChildEventListener () {

				public void onCancelled(FirebaseError arg0) {
					// TODO Auto-generated method stub
					
				}

				public void onChildAdded(DataSnapshot arg0, String arg1) {
					// Add the new child into our child list
					m_ChildListeners.add( arg0.getValue ().toString () );
					
				}

				public void onChildChanged(DataSnapshot arg0, String arg1) {
					// Replace the child in our original list
					int index = m_ChildListeners.indexOf(arg1);
					m_ChildListeners.set ( index, arg0.getValue ().toString () );
					
				}

				public void onChildMoved(DataSnapshot arg0, String arg1) {
					// TODO Auto-generated method stub
					
				}

				public void onChildRemoved(DataSnapshot arg0) {
					// TODO Auto-generated method stub
					
				}
				
			});
		}
	}
}
