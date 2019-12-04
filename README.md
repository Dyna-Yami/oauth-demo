# oauth-demo
Oauth practice

# Get token by password
POST http://localhost:9902/oauth/token?grant_type=password&scope=server&username=jamin&password=password1

# Use token to access resource by gateway
GET http://localhost:9903/user/demo/hello
Header: Authorization bearer {accessToken}

# Jwt Keystore:
keytool -genkeypair -alias mytest -keyalg RSA -keypass mypass -keystore keystore.jks -storepass mypass
# Public Key
keytool -list -rfc --keystore keystore.jks | openssl x509 -inform pem -pubkey
