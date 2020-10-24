import { HasFormatter } from "../interfaces/HasFormatter";

export class ListTemplate {
  constructor(private container: HTMLUListElement) {}

  render(item: HasFormatter, heading: string, pos: "start" | "end") {
    // Create New Element
    const li = document.createElement("li");
    const h4 = document.createElement("h4");
    const p = document.createElement("p");

    // Input content of element
    h4.innerText = heading;
    p.innerText = item.format();

    // Append content to element
    li.append(h4);
    li.append(p);

    // Check pos list start or end
    if (pos === "start") {
      this.container.prepend(li);
    } else {
      this.container.append(li);
    }
  }
}
