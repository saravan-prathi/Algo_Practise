// Not developed fully yet
import java.util.ArrayList;
import java.util.List;

class ConsistentHashing {

	// I am just using an array for the loop here, because essentially in the code,
	// the loop logic has significance only while searching for the next position
	// where a server is assigned[clock-wise], which is being handled as part of the
	// search_next_server function

	private Integer[] loop;
	private int current_number_of_servers;
	private int M; // 0 to M-1 being the output range of our hash functions

	ConsistentHashing(int M, int initial_number_of_servers) {
		this.M = M;
		this.loop = new Integer[M];
		this.current_number_of_servers = initial_number_of_servers;
		init(current_number_of_servers);
	}

	public static void main() {
		while (true) {
			Request request = poll(); // This polling gets the request details
			int server_to_be_sent_to = search_next_server(hash1(request));
			send_request_to_server(request, server_to_be_sent_to); // this function should essentially route the request to the server our load balancer assigns it to.
		}
	}

	// initializing the server positions in the loop
	private void init(int initial_number_of_servers) {
		for (int i = 0; i < initial_number_of_servers; i++) {
			server_assignment(i);
		}
	}

	// This function marks the loop positions with the server numbers
	private void server_assignment(int server_number) {
		List<Integer> temp = new ArrayList<>();
		// passing the server number through a hash function log M times
		//I am not sure how to implement the hash function yet though

		temp.add(hash1(server_id+1)%M);
		temp.add(hash1(server_id+2)%M);
		//
		// and so on till
		//
		temp.add(hash1(server_id+(log M))%M);

		// this function call will mark our loop with the server number in the positions
		// present in the temp list. Hence this field remains null for all the positions
		// to which no server is assigned.
		mark(temp, server_number);

	}

	private void mark(List<Integer> temp, int server_number) {
		for (int i = 0; i < temp.size(); i++) {
			loop[temp.get(i)] = server_number;
		}
	}

	private Integer search_next_server(int k) {
		while (k < M) {
			if (loop[k] != null)
				return loop[k];
			k++;
		}
		// reseting to zero if server is not found till the end of array, and restart
		// searching for the server
		k = 0;
		while (k < M) {
			if (loop[k] != null)
				return loop[k];
			k++;
		}
		return 0; // we don't expect this line to ever run
	}

	public void add_server() {
		this.current_number_of_servers += 1;
		server_assignment(current_number_of_servers);
	}

	public void remove_server(int server_to_be_removed) {
		this.current_number_of_servers -= 1;
		for (int i = 0; i < M; i++) {
			if (loop[i] == server_to_be_removed)
				loop[i] = null;
		}
	}
}
