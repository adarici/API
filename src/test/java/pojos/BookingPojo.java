package pojos;

public class BookingPojo {

        private String firstname;
        private String lastname;
        private Integer totalprice;
        private Boolean depositpaid;
        private BookingdatesPojo bookingdates;

    private String additionalneeds;


        public BookingPojo() {
        }

        public BookingPojo(String firstname, String lastname, Integer totalprice, Boolean depositpaid, BookingdatesPojo bookingdates) {

            this.firstname = firstname;
            this.lastname = lastname;
            this.totalprice = totalprice;
            this.depositpaid = depositpaid;
            this.bookingdates = bookingdates;
        }
    public BookingPojo(String firstname, String lastname, Integer totalprice, Boolean depositpaid, BookingdatesPojo bookingdates, String additinalneeds) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
    }
        public String getFirstname() {
            return firstname;
        }
        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }
        public String getLastname() {
            return lastname;
        }
        public void setLastname(String lastname) {
            this.lastname = lastname;
        }
        public Integer getTotalprice() {
            return totalprice;
        }
        public void setTotalprice(Integer totalprice) {
            this.totalprice = totalprice;
        }
        public Boolean getDepositpaid() {
            return depositpaid;
        }
        public void setDepositpaid(Boolean depositpaid) {
            this.depositpaid = depositpaid;
        }
        public BookingdatesPojo getBookingdates() {
            return bookingdates;
        }
        public void setBookingdates(BookingdatesPojo bookingdates) {
            this.bookingdates = bookingdates;
        }
    public String getAdditionalneeds() {
        return additionalneeds;
    }
    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    @Override
    public String toString() {
        return "BookingPojo{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice=" + totalprice +
                ", depositpaid=" + depositpaid +
                ", bookingdates=" + bookingdates +
                ", additionalneeds='" + additionalneeds + '\'' +
                '}';
    }
}
