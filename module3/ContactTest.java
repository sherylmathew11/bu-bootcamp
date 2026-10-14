
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    private Contact contact;

    @BeforeEach
    void setUp() {
        contact = new Contact("Ada Lovelace", "+1 617 555 0101");
    }

    @Test
    void getNameReturnsCorrectName() {
        assertEquals("Ada Lovelace", contact.getName());
    }

    @Test
    void getPhoneReturnsCorrectPhone() {
        assertEquals("+1 617 555 0101", contact.getPhone());
    }

    @Test
    void toStringReturnsNameAndPhone() {
        assertEquals("Ada Lovelace | +1 617 555 0101", contact.toString());
    }

    @Test
    void constructorStoresNameAndPhone() {
        Contact another = new Contact("Grace Hopper", "+1 212 555 0102");

        assertEquals("Grace Hopper", another.getName());
        assertEquals("+1 212 555 0102", another.getPhone());
    }

    @Test
    void differentContactsHaveDifferentDetails() {
        Contact another = new Contact("Alan Turing", "+1 415 555 0103");

        assertNotEquals(contact.getName(), another.getName());
        assertNotEquals(contact.getPhone(), another.getPhone());
    }

    // Additional test: creating another contact does not change the first
    @Test
    void creatingAnotherContactDoesNotChangeExistingContact() {
        Contact another = new Contact("Grace Hopper", "+1 212 555 0102");

        assertEquals("Ada Lovelace", contact.getName());
        assertEquals("+1 617 555 0101", contact.getPhone());
        assertEquals("Grace Hopper", another.getName());
    }
}
