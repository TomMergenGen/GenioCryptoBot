let counter = 0;

document.addEventListener("DOMContentLoaded", () => {
    const counterElement = document.getElementById("counter");
    const tapButton = document.getElementById("tapButton");

    tapButton.addEventListener("click", () => {
        counter++;
        counterElement.textContent = counter;
    });
});