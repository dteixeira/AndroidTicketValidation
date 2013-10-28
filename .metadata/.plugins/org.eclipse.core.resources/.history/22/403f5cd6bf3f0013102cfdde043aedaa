package org.cmov.ticketclient;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class UnusedTicketAdapter extends BaseAdapter {
	
	private static LayoutInflater inflater = null;
	
	private Context context = null;
	private ArrayList<Ticket> tickets = new ArrayList<Ticket>();
	
	public UnusedTicketAdapter(Context context, ArrayList<Ticket> tickets) {
        this.context = context;
        this.tickets = tickets;
        inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

	public ArrayList<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(ArrayList<Ticket> tickets) {
		this.tickets = tickets;
	}

	@Override
	public int getCount() {
		return tickets.size();
	}

	@Override
	public Object getItem(int arg0) {
		return tickets.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.unused_ticket_row, null);
		}
		Ticket ticket = tickets.get(position);
		TextView type = (TextView) convertView.findViewById(R.id.ticket_type);
		TextView duration = (TextView) convertView.findViewById(R.id.ticket_duration);
		duration.setText(ticket.getValidityTime() + " minutes");
		switch(ticket.getValidityTime()) {
		case 15:
			type.setText("Ticket T1");
			break;
			
		case 30:
			type.setText("Ticket T2");
			break;
			
		case 60:
			type.setText("Ticket T3");
			break;
			
		default:
			break;
		}
		return convertView;
	}

}
