var User = /** @class */ (function () {
    function User(gender, hobby, phone) {
        this.gender = gender;
        this.hobby = hobby;
        this.phone = phone;
    }
    User.prototype.format = function () {
        var typeGender;
        this.gender === "female" ? (typeGender = "her") : (typeGender = "his");
        return typeGender + " gender is a " + this.gender + " who has a hobby of " + this.hobby + " and has a phone number is " + this.phone;
    };
    return User;
}());
export { User };
