package iotalarm.dataaccess;

import iotalarm.domain.Event;

public class Test {
public static void main(String[]args) {
	EventReader.getInstance().updateUrl("https://mijnrooster.sharepoint.hu.nl/ical?eu=U1REXDE2OTk4ODI=&h=EXkdVgn2Q-GOvtBTfHzzYFznvxe0sTz1sQn0wX6DQkc=");
	for (Event e:EventReader.getTodaysEvents()) {
		System.out.println(e.getTitle()+" - "+e.getDate());
	}
}
}
