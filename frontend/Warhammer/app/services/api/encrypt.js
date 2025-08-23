import { Platform } from 'react-native';
import { JSEncrypt } from 'jsencrypt';

// Path to the public key file
const PUBLIC_KEY_PATH = Platform.select({
  web: '/public_key.pem',
  default: 'public_key.pem',
});

let cachedPublicKey = null;

export async function loadPublicKey() {
  if (cachedPublicKey) return cachedPublicKey;
  // For web, fetch from public folder; for native, require or fetch from assets
  if (Platform.OS === 'web') {
    const response = await fetch(PUBLIC_KEY_PATH);
    cachedPublicKey = await response.text();
    return cachedPublicKey;
  } else {
    // For native, you may need to bundle the key or fetch from server
    // Here, we assume it's in the project root and can be fetched
    const response = await fetch(PUBLIC_KEY_PATH);
    cachedPublicKey = await response.text();
    return cachedPublicKey;
  }
}

export async function encryptWithPublicKey(plainText) {
  const publicKey = await loadPublicKey();
  const encryptor = new JSEncrypt();
  encryptor.setPublicKey(publicKey);
  const encrypted = encryptor.encrypt(plainText);
  if (!encrypted) throw new Error('Encryption failed');
  return encrypted;
} 