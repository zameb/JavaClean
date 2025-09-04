[Back](https://github.com/zameb/JavaClean#readme)
## Clean Code Principles

While I am happy to adhere to team-specific rules in collaborative environments, the following principles guide this project's codebase:

*   **Small, Focused Methods**
    *   Strive for methods that are concise and do one thing well. A method should be readable without scrolling.
    *   Break long methods into smaller, private helper methods. This is a primary refactoring technique for improving readability.
    *   **Watch for this signal:** A cluster of private methods often hints at a hidden responsibility or concept within your class. 
        When you notice this, it's a strong candidate for extraction into its own class, reinforcing the Single Responsibility Principle (SRP).
*   **Prefer Clear Code over Comments**
    *   Code should be self-documenting. Avoid comments that simply restate what the code is doing (Don't Repeat Yourself - DRY).
    *   Comments are not maintained by the compiler and can easily become outdated, leading to misinformation.
    *   Comments clutters otherwise clean and concise classes. Express intent through clear naming and structure instead.
*   **Use `var` for Improved Readability**
    *   Use `var` for local variables whenever possible, not only when the type is obvious from the right-hand side of the assignment 
        (e.g., `var user = userService.getUser(id);`). This emphasizes the *what* (a user) over the *how* (the specific implementation type) at a high level.
    *   This practice encourages meaningful variable and method names. The context should make the usage without knowing the specific type.
        High-level code benefits from hiding implementation details. The need for specific type information should naturally lead you to the method's implementation.

