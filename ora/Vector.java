package ora;


	public class Vector {
		private int[] data;
		private int capacity;
		private int size;
		
		public Vector(int initialCapacity) {
			data = new int[initialCapacity];
			capacity = initialCapacity;
			this.size = 0; 
		}
		
		private void add(int x) {
			if (size < capacity) {
				data[size] = x;
				size += 1;
			} else {
				int[] new_data = new int[capacity + 1];
				for (int i = 0; i < capacity; i++) {
					new_data[i] = data[i];
				}
				new_data[size] = x;
				size += 1;
				capacity += 1;
				data = new_data;
			}
		}
		
		// A nulladik elemet kitörli, és visszatér vele
		public int pop() {
			int result;
			if (size > 0) {
				result = data[0];
				for (int i = 1; i < size; i++) {
					data[i-1] = data[i];
				}
				size -= 1;
				return result;
			} else {
				throw new IndexOutOfBoundsException("Üres a lista");
			}
			
		}
		
		public String toString() {
			String representation = "[";
			for (int i = 0; i < size-1; i++) {
				representation += data[i];	// data[i] -> int típusú, boxing => Integer -> Integer.toString()
				representation += " ";
			}
			// Külön kezeljük az utolsó elemet, hogy ne legyen már szóköz utána
			representation += data[size-1];
			representation += "]";
			return representation;
		}
		
		
		public static void main(String[] args) {
			Vector v = new Vector(6);
			v.add(5);
			v.add(9);
			v.add(8);
			v.add(13);
			v.add(7);
			v.add(43);
			v.add(108);
			System.out.println(v);
		}


	}
