public class UserData {
        public String firstName;
        public String lastName;
        public String email;
        public String password;
        public int day;
        public String month;
        public int year;

        public String address;
        public String city;
        public String state;
        public int postalCode;
        public String phone;
        public int country;

        public UserData(
                String firstName,
                String lastName,
                String email,
                String password,
                int day,
                String month,
                int year,
                String address,
                String city,
                String state,
                int postalCode,
                int country,
                String phone
        ) {

            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.password = password;
            this.day = day;
            this.month = month;
            this.year = year;

            this.address = address;
            this.city = city;
            this.state = state;
            this.postalCode = postalCode;
            this.country = country;
            this.phone = phone;
        }
}
