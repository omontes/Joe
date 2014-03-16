SELECT F.Fecha,F.Concepto,F.idFactura,F.`TotalTarjeta`,F.`TotalContado`
FROM factura AS F
WHERE F.Estado='A' AND F.Concepto ='Cancelada' AND F.Fecha BETWEEN ? AND ?
ORDER BY F.Concepto;


