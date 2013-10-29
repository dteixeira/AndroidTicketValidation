package org.cmov.ticketclient;

import java.util.ArrayList;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.ListFragment;
import android.view.ViewGroup;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

	private ArrayList<Fragment> fragments = null;
	private ArrayList<String> fragmentNames = null;
	private MainActivity activity = null;

	public SectionsPagerAdapter(FragmentManager fragmentManager, 
			ArrayList<Fragment> fragments, ArrayList<String> fragmentNames, MainActivity activity) {
		super(fragmentManager);
		this.fragments = fragments;
		this.fragmentNames = fragmentNames;
		this.activity = activity;
	}

	@Override
	public Fragment getItem(int position) {
		if(position == 0) {
			((ListFragment) fragments.get(position)).setListAdapter(activity.mUnusedTicketsAdapter);
		} else if(position == 1) {
			((ListFragment) fragments.get(position)).setListAdapter(activity.mUsedTicketsAdapter);
		} else if(position == 2) {
			
			((TicketPresentFragment) fragments.get(position)).ticket = activity.recentTicket;
		}
		return fragments.get(position);
	}

	@Override
	public int getCount() {
		return fragments.size();
	}
	
	@Override
	 public Object instantiateItem(ViewGroup container, int position) {
		Fragment fragment = (Fragment) super.instantiateItem(container, position);
		if(position == 0) {
			((ListFragment) fragments.get(position)).setListAdapter(null);
			((ListFragment) fragment).setListAdapter(activity.mUnusedTicketsAdapter);
		} else if(position == 1) {
			((ListFragment) fragments.get(position)).setListAdapter(null);
			((ListFragment) fragment).setListAdapter(activity.mUsedTicketsAdapter);
		} else if(position == 2) {
			((TicketPresentFragment) fragments.get(position)).ticket = activity.recentTicket;
		}
		fragments.set(position, fragment);
		return fragment;
	 }

	@Override
	public CharSequence getPageTitle(int position) {
		return fragmentNames.get(position);
	}
}