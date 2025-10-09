-- Remove duplicate products, keeping only the first occurrence
DELETE FROM products
WHERE
    product_id NOT IN(
        SELECT MIN(product_id)
        FROM products
        GROUP BY
            name
    );

-- Add unique constraint if it doesn't exist
ALTER TABLE products
ADD CONSTRAINT products_name_unique UNIQUE (name);