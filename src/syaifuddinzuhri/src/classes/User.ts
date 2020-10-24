import { HasFormatter } from "../interfaces/HasFormatter.js";

export class User implements HasFormatter {
  constructor(
    private gender: string,
    private hobby: string,
    private phone: number
  ) {}

  format() {
    let typeGender: string;
    this.gender === "female" ? (typeGender = "her") : (typeGender = "his");

    return `${typeGender} gender is a ${this.gender} who has a hobby of ${this.hobby} and has a phone number is ${this.phone}`;
  }
}
