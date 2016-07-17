/**
 * 
 */
package ru.alexst.certification.ocp.par9.nio;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
import static java.nio.file.StandardWatchEventKinds.OVERFLOW;
import static ru.alexst.certification.ocp.par9.io.files.FileBasic.insertHome;

import java.io.IOException;
import java.nio.channels.OverlappingFileLockException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;

/**
 * @author Алексей
 *
 */
public class WatchServiceBasic {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Path dir = Paths.get("C:/alexfiles"); // get directory containing
		// file/directory we care
		// about
		WatchService watcher = FileSystems.getDefault().newWatchService(); // file system specific code create empty watch service
		dir.register(watcher, ENTRY_DELETE, ENTRY_CREATE, ENTRY_MODIFY, OVERFLOW); // needs a static import!
		// start watching for deletions
		while (true) { // loop until say to stop
			WatchKey key;
			try {
				key = watcher.take(); // wait for a deletion
			} catch (InterruptedException x) {
				x.printStackTrace();
				return; // give up if something goes wrong
			}
			List<WatchEvent<?>> eventList = key.pollEvents();
			for (WatchEvent<?> event : eventList) {
				WatchEvent.Kind<?> kind = event.kind();
				System.out.println(kind.name()); // create/delete/modify
				System.out.println(kind.type()); // always a Path for us
				System.out.println(event.context()); // name of the file
				String name = event.context().toString();
				if (name.equals("y3")) { // only delete right directory
					System.out.format("Directory deleted, now we can proceed");
					return; // end program, we found what we were waiting for
				}
			}
			System.out.println(key.reset()); // keep looking for events
		}
		
	}
	
	

}
