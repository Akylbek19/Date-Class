# Date Class Implementation in Java

## Project Overview
This project implements a robust `Date` class in Java that handles date operations including:
- Date validation (including leap years)
- Date updates
- Day of week calculation
- Date difference calculation
- Date sorting capabilities

## Key Features
- Complete date validation
- Zeller's Congruence algorithm for day of week
- Accurate date difference calculation (counting all intermediate days)
- Natural sorting by year, month, day
- Multiple display formats

## Compilation and Execution

### Requirements
- Java JDK 11 or later
- Git (optional)

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/Date-Java-Project.git
   cd Date-Java-Project
   ```

2. Compile the source files:
   ```bash
   javac src/*.java -d ./out
   ```

3. Run the demonstration program:
   ```bash
   java -cp ./out Main
   ```

### Expected Output
```
Today: 15/06/2023
Error creating date: Invalid date: 31/4/2023
Invalid date test: failed
Updated date: 20/06/2023
Day of week: Tuesday
```

## Implementation Notes
1. **Leap Year Handling**: Uses precise 400-year cycle calculation
2. **Date Difference**: Counts actual calendar days between dates
3. **Sorting**: Implements `Comparable<Date>` for natural ordering
4. **Error Handling**: Comprehensive validation with clear error messages

## Challenges Faced
1. Accurate day count calculation across month/year boundaries
2. Handling edge cases in date validation
3. Optimizing the day difference algorithm