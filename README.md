# <center>Oops! All Magic


## <center>Code Flow Concept
<div style="text-align:center;">
<img src="images/potionShopFlow.PNG" width="1200" alt="Flow Chart"/>
</div>


## <center>My Classes and Their Uses
| Interface        | Purpose                                                                                                                       |
|------------------|-------------------------------------------------------------------------------------------------------------------------------|
| <center> Product | <center> Covers all classes that have a "name" and "price" variable so that these are required for any further implementation |



| Abstract Classes  | Purpose                                                                                                                     |
|-------------------|-----------------------------------------------------------------------------------------------------------------------------|
| <center> MenuItem | <center> Implements Product interface and acts as a parent for Side, Elixir, and Potion                                     |
| <center> Elixir   | <center> Extends MenuItem class and acts as a parent for SundropSpritz, ThunderMead, and GarlicJuice                        |
| <center> Side     | <center> Extends MenuItem class and acts as a parent for DragonScaleChips, PhoenixFeatherFries, and ToadstoolBites          |
| <center> Topping  | <center> Implements Product interface and acts as a parent to any product classes that should not be orderable individually |



| Classes                 | Purpose                                                                                                                                                                                                                 |
|-------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| <center> Potion         | <center> Extends MenuItem class. This class contains "ArrayList<Topping> toppings" and has the option to be large, medium, or small and "flavored" as a health, stamina, or strength potion. This makes up my main dish |
| <center> Order          | <center> Interacts with the UserInterface and holds any created MenuItems in an ArrayList<MenuItems>                                                                                                                    |
| <center> UserInterface  | <center> Handles screens and user inputs. On start(), a new Order object is created and nagivating the screens will allow users to constomize and save their order                                                      |
| <center> FileManagement | <center> When saveReceipt() is called on an Order object, a JSON object is dynamically created and saved to the resources/receipts file and a receipt with order information is generated using the AsciiTable library  |

## <center>Interesting Code
<div style="text-align:center;">
<img src="images/JSONBlock.PNG" width="600" alt="Jackson Code Implementation"/>
</div>

### <center>Using the Jackson library, I iterate through my MenuItems within the given Order object and create a new JSON object with all of the information nested dynamically
---
<div style="text-align:center;">
<img src="images/AsciiTableBlock.PNG" width="600" alt="Ascii Table Implementation"/>
</div>

### <center>Using the AsciiTable library, I iterate through my MenuItems within the given Order object and create a chart where each MenuItem's name, price, and description are displayed