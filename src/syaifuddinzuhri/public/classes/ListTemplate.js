var ListTemplate = /** @class */ (function () {
    function ListTemplate(container) {
        this.container = container;
    }
    ListTemplate.prototype.render = function (item, heading, pos) {
        // Create New Element
        var li = document.createElement("li");
        var h4 = document.createElement("h4");
        var p = document.createElement("p");
        // Input content of element
        h4.innerText = heading;
        p.innerText = item.format();
        // Append content to element
        li.append(h4);
        li.append(p);
        // Check pos list start or end
        if (pos === "start") {
            this.container.prepend(li);
        }
        else {
            this.container.append(li);
        }
    };
    return ListTemplate;
}());
export { ListTemplate };
