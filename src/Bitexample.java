import java.util.Arrays;

public class Bitexample {

	private static final int[] CHOICES = {
			1 << 0, // 0b00000001, 0x00001
			1 << 1, // 0b00000010, 0x00002
			1 << 2, // 0b00000100, 0x00004
			1 << 3, // 0b00001000, 0x00008
			1 << 4, // 0b00010000, 0x00010
			1 << 5, // 0b00100000, 0x00020
			1 << 6, // 0b01000000, 0x00040
			1 << 7  // 0b10000000  0x00080
		};

	public static void main(String[] args) {
		System.out.println(Arrays.toString(CHOICES));

		final int choice = 67;
		System.out.println(Integer.toBinaryString(choice));
		for (int i : CHOICES) {
			if ((i & choice) != 0) {
				System.out.println("Choice: " + i);
			}
		}
		
		
		
		
		
//		int choices = CHOICES[1] | CHOICES[3] | CHOICES[5];
//		System.out.println(choices);
//		
//		for (int i = 0; i < CHOICES.length; i++) {
//			int activated = (choices & CHOICES[i]);
//			
//			System.out.println(i + " -> " + activated);
//			if (activated > 0)
//				System.out.println("Selected " + CHOICES[i]);
//		}
	}
}
