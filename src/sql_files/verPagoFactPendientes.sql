SELECT PFP.Fecha AS FechaPago,PFP.MontoDePago AS Monto
FROM factura AS F,facturaspendientes AS FP, pagosfactpendientes AS PFP
WHERE F.Estado ='A' AND F.idFactura=FP.idFactura AND F.idFactura=? AND (F.Concepto='Apartado' OR F.Concepto='Credito')
AND PFP.idFacturaVersionPagosPend=FP.idVersionFactPendientes AND F.idVersionFactura=FP.idVersionFactPendientes AND PFP.idFacturaPendiente=FP.idFactura;
