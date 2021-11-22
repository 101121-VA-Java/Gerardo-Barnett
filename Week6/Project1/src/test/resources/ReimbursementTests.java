
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)

public class ReimbursementTests {
	
	@Mock
	private ReimbursementDao rd;
	
	@InjectMocks
	private ReimbursementService rs;
	
	@Test
	public void submitMyRequestTest() {
		Mockito.when(rs.submitMyRequest(null).thenReturn(true));
		boolean expected = true;
		boolean actual = rs.submitMyRequest(null);
		assertEquals(expected, actual);
	}
	
	public void

}
