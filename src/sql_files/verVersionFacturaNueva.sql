SELECT F.idVersionFactura
FROM factura AS F
WHERE F.idFactura=? AND F.Estado='A';
