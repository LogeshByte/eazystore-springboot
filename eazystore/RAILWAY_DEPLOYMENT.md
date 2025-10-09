# Railway Deployment Guide

## Required Environment Variables

Set these in your Railway project settings:

### Database Configuration (from Railway MySQL service)
```
MYSQLHOST=<your-mysql-host>
MYSQLPORT=<your-mysql-port>
MYSQLDATABASE=<your-database-name>
MYSQLUSER=<your-mysql-username>
MYSQLPASSWORD=<your-mysql-password>
```

### Application Configuration
```
SPRING_PROFILES_ACTIVE=prod
PORT=8080
LOG_LEVEL=INFO
```

### Security Configuration
```
JWT_SECRET=<your-secure-jwt-secret-key>
STRIPE_API_KEY=<your-stripe-api-key>
```

## Deployment Steps

1. **Commit and push all changes:**
   ```bash
   git add .
   git commit -m "Fix Railway deployment configuration"
   git push
   ```

2. **Set environment variables in Railway:**
   - Go to your Railway project
   - Click on your service
   - Go to "Variables" tab
   - Add all required environment variables above

3. **Redeploy:**
   - Railway will automatically redeploy after push
   - Or manually trigger redeploy from Railway dashboard

## Testing Endpoints

### Health Check (Public)
```bash
curl https://your-app.railway.app/eazystore/actuator/health
```

Expected response:
```json
{"status":"UP"}
```

### API Documentation (Requires Authentication)
```
https://your-app.railway.app/swagger-ui/index.html
```

### Test Product API (Public)
```bash
curl https://your-app.railway.app/api/v1/products
```

### Test Contact API (Public)
```bash
curl -X POST https://your-app.railway.app/api/v1/contacts \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Test User",
    "email": "test@example.com",
    "subject": "Test",
    "message": "Testing API"
  }'
```

## Troubleshooting

### 502 Bad Gateway
- Check Railway logs for startup errors
- Verify all environment variables are set
- Ensure MySQL service is running and connected
- Check if health endpoint is accessible

### Database Connection Issues
- Verify MySQL environment variables match Railway MySQL service
- Check if database exists
- Ensure MySQL service is in the same Railway project

### Authentication Issues
- Verify JWT_SECRET is set
- Check STRIPE_API_KEY is valid
- For Swagger UI, you need DEV_ENG or QA_ENG role

## Important Notes

- Health endpoint is now public for Railway health checks
- Actuator endpoints require OPS_ENG role (except health)
- Swagger UI requires DEV_ENG or QA_ENG role
- Admin endpoints require ADMIN role
- CORS is configured for localhost:5173 (update in production)
