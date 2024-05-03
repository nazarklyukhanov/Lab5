/**
 * The Label class represents the label of a music band, including sales information.
 */
package recources;

public class Label {
        private Integer sales; // The field cannot be null, and its value must be greater than 0

        /**
         * Constructs a new Label object with the specified sales value.
         *
         * @param sales the sales value of the label
         */
        public Label(Integer sales) {
                this.sales = sales;
        }

        /**
         * Retrieves the sales value of the label.
         *
         * @return the sales value
         */
        public Integer getSales() {
                return sales;
        }
}
