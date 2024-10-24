
# Read input values
initial_inventory, purchased, sold, max_capacity, daily_sales_limit, discount_threshold = map(float, input().split())

# Apply Bulk Purchase Discount (10% off if purchased quantity > threshold)
if purchased > discount_threshold:
    purchased *= 0.9

# Check if the purchase affects the inventory (only if purchased quantity >= 20% of max capacity)
if purchased < 0.2 * max_capacity:
    purchased = 0

# Calculate max allowed sales for the day (percentage of current inventory)
allowed_sales = initial_inventory * (daily_sales_limit / 100)

# Adjust sold quantity if it exceeds daily allowed sales
if sold > allowed_sales:
    sold = allowed_sales

# Restrict sales if inventory is below 30% of max capacity
if initial_inventory < 0.3 * max_capacity:
    sold = min(sold, 0.5 * initial_inventory)

# Update the inventory
updated_inventory = initial_inventory + purchased - sold

# Output the result rounded to one decimal
print(f"{round(updated_inventory, 1)}")

