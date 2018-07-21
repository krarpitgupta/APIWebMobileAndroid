/*
 ***************************************************************************************
 * Interface-Name:       src/ApplicationComponent/ApplicationComponent
 * Description:          "ApplicationComponent" interface, which consists of various 
 * methods' declaration to define reusable end-to-end flows of ShopClues Application
 * Author:               Sahil Jariwala
 * Dated:                09Apr2015
 * Notes:  
 *
 ***************************************************************************************
 */

package applicationComponent;

public interface ApplicationComponent {

	void openApplication();
	void closeApplication();
	void validateHomePage();
	void navigateVerifyProductPage();
	void buyNowVerifyCart() throws Exception;
	void verifyCheckoutAddressPage();
	
}
