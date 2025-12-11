package hust.soict.dsai.aims.screen;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;

public class CartScreen extends JFrame {

    private static final long serialVersionUID = 1L;
    private Cart cart;

    public CartScreen(Cart cart) {
        super();
        this.cart = cart;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Cart");
        this.setSize(1024, 768);           // optional: reasonable default size
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        Platform.runLater(() -> {
            try {
                FXMLLoader loader = new FXMLLoader(CartScreen.class.getResource("/hust/soict/dsai/aims/screen/cart.fxml"));
                
                // Tạo controller có cart
                CartScreenController controller = new CartScreenController(cart);
                
                // Set controller thủ công
                loader.setController(controller);
                
                Parent root = loader.load();
                Scene scene = new Scene(root);
                fxPanel.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    // ADD THIS TO TEST CARTSCREEN ALONE
    public static void main(String[] args) {
        // Create a dummy cart with some test items
        Cart testCart = new Cart();

        // Add some sample media (DVD, Book, CD) – same as in StoreScreen.main()
        testCart.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        testCart.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 120, 24.95f));
        testCart.addMedia(new Book("Harry Potter", "Fantasy", 29.99f));
        testCart.addMedia(new CompactDisc("Thriller", "Pop", 15.99f, "Michael Jackson"));
        testCart.addMedia(new Book("Clean Code", "Technology", 45.00f));

        // Must run on Swing thread because of JFXPanel
        SwingUtilities.invokeLater(() -> {
            new CartScreen(testCart);
        });
    }
}